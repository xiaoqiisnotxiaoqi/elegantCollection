package com.elegantcollection.controller;

import com.elegantcollection.entity.*;
import com.elegantcollection.service.AuthorService;
import com.elegantcollection.service.BookService;
import com.elegantcollection.service.CartService;
import com.elegantcollection.service.DiscountService;
import com.elegantcollection.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class CartController {
    private final CartService cartService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final DiscountService discountService;

    @Autowired
    public CartController(CartService cartService, BookService bookService, AuthorService authorService, DiscountService discountService) {
        this.cartService = cartService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.discountService = discountService;
    }


    /**
     * 查看购物车中商品的数量
     *
     * @param request 请求信息
     * @return 购物车中商品的数量
     */
    @GetMapping("/cartNum")
    public Integer cartNum(HttpServletRequest request) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        //得到用户id
        Integer custId = customer.getCustId();
        //根据用户id查找 用户购物车中所有物品
        List<Cart> cartList = cartService.quaryCartByCustId(custId);
        int i = 0;
        for (Cart cart : cartList) {
            i += cart.getQuality();
        }
        return i;
    }


    /**
     * 查看购物车
     *
     * @param request 用户请求信息
     * @return 购物车分页
     */
    @GetMapping("/cart")
    public PageModel<Map<String, Object>> customerCart(HttpServletRequest request, String currentPageCode) {
        //从session中得到用户信息
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if (customer == null) {
            return null;
        }
        PageModel<Map<String, Object>> pageModel = new PageModel<>();

        List<Map<String, Object>> bookList = new ArrayList<>();

        //得到用户id
        Integer custId = customer.getCustId();
        //根据用户id查找 用户购物车中所有物品
        List<Cart> cartList = cartService.quaryCartByCustId(custId);

        //每页显示商品的数量
        pageModel.setPageSize(8);

        //用户购物车商品种类数量
        pageModel.setTotalRecord(cartList.size());

        //总页数
        if (cartList.size() % pageModel.getPageSize() != 0) {
            pageModel.setTotalPages(cartList.size() / pageModel.getPageSize() + 1);
        } else {
            pageModel.setTotalPages(cartList.size() / pageModel.getPageSize());
        }

        //客户要查询的购物车页数
        if (currentPageCode == null || Integer.valueOf(currentPageCode) < 1) {
            //如果页数为null 或者 页数小于1 则查询第一页
            pageModel.setCurrentPageCode(1);
        } else if (Integer.valueOf(currentPageCode) > pageModel.getTotalPages()) {
            //如果页码大于最大页码,则查询最后一页
            pageModel.setCurrentPageCode(pageModel.getTotalPages());
        } else {
            pageModel.setCurrentPageCode(Integer.valueOf(currentPageCode));
        }


        //从第几条记录开始
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());

        //分页查询,得到数据
        List<Cart> list = cartService.quaryCartByPage(custId, 8, pageModel.getStartRecord());
        //到第几条记录结束显示
        pageModel.setEndRecord(pageModel.getStartRecord() + list.size() - 1);
        //遍历购物车,得到图书详情
        for (Cart cart : list) {
            Book book = bookService.quaryBookByBookId(cart.getBookId());
            //将页面要显示的信息 封装成为map
            Map<String, Object> map = new HashMap<>();
            map.put("bookId", book.getBookId());
            map.put("bookName", book.getBookName());
            map.put("bookImg", book.getBookImg());
            map.put("publishingName", book.getPublishingName());
            map.put("bookNum", cart.getQuality());
            map.put("bookPrice", book.getBookSellingPrice());
            Author author = authorService.queryAuthorById(book.getAuthorId());
            map.put("authorName", author.getAuthorName());
            bookList.add(map);
        }
        pageModel.setModelList(bookList);
        return pageModel;
    }


    /**
     * 删除购物车中的一种书籍
     *
     * @param request         用户的请求信息
     * @param currentPageCode 购物车的页数
     * @param bookId          要删除的图书id
     * @return 购物车分页
     */
    @DeleteMapping("/deleteCustomerCart")
    public PageModel<Map<String, Object>> deleteCustomerCart(HttpServletRequest request, String currentPageCode, String bookId) {
        System.out.println(bookId);
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        cartService.removeByBookId(bookId, customer.getCustId());
        return customerCart(request, currentPageCode);
    }


    /**
     * 查找 要购买的图书中的 组合优惠
     *
     * @param map 用户 准备购买的书籍 以及数量
     * @return 组合优惠信息
     */
    private Map<String, Float> priceStatistics(Map<String, String> map) {
        if (map.size() == 0) {
            return null;
        }
        float price = 0f;
        List<Integer> list = new ArrayList<>();

        //得到用户选择的所有的图书,以及 不含优惠时的总价格 和与该用户选择的图书的所有的满减优惠信息
        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            //通过bookid 得到该图书的详情
            Book book = bookService.quaryBookByBookId(Integer.valueOf(entry.getKey()));
            //得到所购买的 该本图书的总价格
            price += (book.getBookSellingPrice() * Integer.valueOf(entry.getValue()));
            //得到该图书所关联的 组合优惠信息
            String favorable = book.getRedundancyField();
            if (favorable != null) {
                String[] favorables = favorable.split(" ");
                //将 该本书 关联的所有的 优惠信息的id 存入到list中
                for (String f : favorables) {
                    list.add(Integer.valueOf(f));
                }
            }
        }

        float preferentialPrice = 0f;

        if (list.size() != 0) {
            for (Integer discountId : list) {
                DiscountDetail discountDetail = discountService.quereDiscountDetailByDiscountId(discountId);
                //判断组合优惠中的 优惠 图书 是两本 还是三本
                if (discountDetail.getBookId() != null && discountDetail.getMore1() != null && discountDetail.getMore2() != null) {
                    //优惠图书是三本,查询该用户购买的图书是否包含这三本图书,如果包含 则优惠价格加上 该组合的优惠价格
                    if (map.get(discountDetail.getBookId().toString()) != null &&
                            map.get(discountDetail.getMore1()) != null &&
                            map.get(discountDetail.getMore2()) != null) {
                        Discount discount = discountService.quertDiscountByDiscountId(discountId);
                        if (discount == null) {
                            Map<String, Float> map1 = new HashMap<>();
                            map1.put("groupPrice", price);
                            map1.put("groupDiscount", 0f);
                            return map1;
                        }
                        preferentialPrice += discount.getDiscountMoney();

                        //如果 该组合套餐所包含的书籍 的购买的数量 大于1时 则数量减1 等于一是 则置为 null
                        int a = Integer.valueOf(map.get(discountDetail.getBookId().toString())) - 1;
                        int b = Integer.valueOf(map.get(discountDetail.getMore1())) - 1;
                        int c = Integer.valueOf(map.get(discountDetail.getMore2())) - 1;

                        if (map.get(discountDetail.getBookId().toString()).equals("1")) {
                            map.remove(discountDetail.getBookId().toString());
                        } else {
                            map.put(discountDetail.getBookId().toString(), Integer.toString(a));
                        }

                        if (map.get(discountDetail.getMore1()).equals("1")) {
                            map.remove(discountDetail.getMore1());
                        } else {
                            map.put(discountDetail.getMore1(), Integer.toString(b));
                        }

                        if (map.get(discountDetail.getMore2()).equals("1")) {
                            map.remove(discountDetail.getMore2());
                        } else {
                            map.put(discountDetail.getMore2(), Integer.toString(c));
                        }


                    }

                } else {
                    assert discountDetail.getBookId() != null;
                    if (map.get(discountDetail.getBookId().toString()) != null &&
                            map.get(discountDetail.getMore1()) != null) {

                        Discount discount = discountService.quertDiscountByDiscountId(discountId);
                        if (discount == null) {
                            Map<String, Float> map1 = new HashMap<>();
                            map1.put("groupPrice", price);
                            return map1;
                        }
                        preferentialPrice += discount.getDiscountMoney();

                        int a = Integer.valueOf(map.get(discountDetail.getBookId().toString())) - 1;
                        int b = Integer.valueOf(map.get(discountDetail.getMore1())) - 1;

                        if (map.get(discountDetail.getBookId().toString()).equals("1")) {
                            map.remove(discountDetail.getBookId().toString());
                        } else {
                            map.put(discountDetail.getBookId().toString(), Integer.toString(a));
                        }

                        if (map.get(discountDetail.getMore1()).equals("1")) {
                            map.remove(discountDetail.getMore1());
                        } else {
                            map.put(discountDetail.getMore1(), Integer.toString(b));
                        }

                    }
                }
            }
        }

        //计算出 用户所购买的图书 实际 应该支付多少钱(减去 组合优惠所优惠的价格)
        Map<String, Float> map1 = new HashMap<>();
        map1.put("groupPrice", price);
        map1.put("groupDiscount", preferentialPrice);
        return map1;
    }


    /**
     * 查找要购买的图书中的 满减优惠
     *
     * @param map 用户准备购买的 书籍 以及数量
     * @return 满减优惠信息
     */
    private Map<String, Float> withPreferentialReduction(Map<String, String> map) {
        if (map.size() == 0) {
            return null;
        }
        float price = 0f;
        float discountAmount = 0f;
        List<Integer> list = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        //得到用户选择的所有的图书,以及 不含优惠时的总价格 和与该用户选择的图书的所有的满减优惠信息
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //通过bookid 得到该图书的详情
            Book book = bookService.quaryBookByBookId(Integer.valueOf(entry.getKey()));
            //得到所购买的 该本图书的总价格
            price += (book.getBookSellingPrice() * Integer.valueOf(entry.getValue()));
            bookList.add(book);
            //得到该图书所关联的 组合优惠信息
            String favorable = book.getRedundancyField2();
            if (favorable != null) {
                String[] favorables = favorable.split(" ");
                //将 该本书 关联的所有的 优惠信息的id 存入到list中
                for (String f : favorables) {
                    list.add(Integer.valueOf(f));
                }
            }
        }
        List<Float> floatList = new ArrayList<>();
        //遍历得到 参与优惠的图书的总价格
        for (Integer i : list) {
            float preferentialReduction = 0f;
            //根据优惠id得到该优惠详情的 详细信息
            Discount discount = discountService.quertDiscountByDiscountId(i);
            if (discount == null) {
                Map<String, Float> map1 = new HashMap<>();
                map1.put("fullReductionPrice", price);
                map1.put("fullReductionDiscount", 0f);
                return map1;
            }

            for (Book book : bookList) {
                System.out.println(book);
                if (book.getRedundancyField2() != null && book.getRedundancyField2().indexOf(i) != -1) {
                    preferentialReduction += book.getBookSellingPrice();
                }
            }
            //当总金额 达到减免的条件时 ,则将应该减免的金额放入到集合中
            if (preferentialReduction > Float.valueOf(discount.getMore1())) {
                floatList.add(discount.getDiscountMoney());
            }
        }
        for (Float f : floatList) {
            if (f > discountAmount) {
                discountAmount = f;
            }
        }
        Map<String, Float> map1 = new HashMap<>();
        map1.put("fullReductionPrice", price);
        map1.put("fullReductionDiscount", discountAmount);
        return map1;
    }


    /**
     * 根据用户传来的 图书id 以及数量 得到该用户购物车的满减优惠以及组合优惠
     *
     * @param map "图书id":"该图书的数量" 封装的map集合
     * @return 组合优惠金额 满减优惠金额 以及总金额 封装的map
     */
    @PostMapping("/priceShow")
    public Map<String, Float> pricesShown(@RequestParam Map<String, String> map) {
        if (map.size() != 0) {
            Map<String, Float> map1 = withPreferentialReduction(map);
            Map<String, Float> map2 = priceStatistics(map);
            assert map1 != null;
            Map<String, Float> map3 = new HashMap<>(map1);
            assert map2 != null;
            map3.putAll(map2);

            return map3;
        } else {
            return null;
        }
    }


    /**
     * 根据用户 选择结算的书籍 将其从购物车中删除
     * @param map 用户 选择的 书籍对应的map(图书id:数量 以及 价格详情)
     * @param request 用户的请求信息
     * @return "success"
     */
    @PostMapping("butNow")
    public String butNow(@RequestParam Map<String, String> map, HttpServletRequest request) {
        request.getSession().setAttribute("buyThis", map);
        int a = map.size() - 3;
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key=" + key + " value=" + value);
            if (i < a - 3) {
                cartService.removeByBookId(key,((Customer) request.getSession().getAttribute("customer")).getCustId());
            }
            i++;
        }
        System.out.println(map);
        return "success";
    }

}
