package com.elegantcollection.util;

public class  AlipayConfig {
	// 商户appid
	public static String APPID = "2016092000557177";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCH4sPUkYdI9wUzmHErHVqNjggZp0UO+unC1T6B89s5ppwfyztL7i7pKNU1v6v1iOr5yAL5Di6/nQmKXsU6673waXSSTlJ5uLxe7Oum7u510wvuT0Hp1uL8yzSWZROQ8gIFoWRDXsymLAEXCld5Q4LXXWm862+9ltsvXgJ+CbhLoyK/cu5kYPShzZlaK8O4z/StmjYwuPJKCgnJvNJEyfXTQLFDOZF/qabvxOhmaTB13hzmCKqA9z3XA0KADvUOvzUM7S1KqgqF70o0c0OHv0MH7Li7eqaGmFQPqNjnIA+DHuasYT4qTNpuFnHzOP6fgcAb1kNIwZV66U1SqYZJ2QjhAgMBAAECggEAOfssjDs8eonMkmNthnQT+2qrUibpdKbjr9rFvTWMSWEqJPbW6mNLaPmfYDvU6APwH3yUqCjBEcm0FHKzvZxxg2+76eG5l26YEfkN5ED3RxcydBElkt26JRuf6LxgSOy6qCRhX83HjPAh1u72vCtuXO7i+1WKbF8+T0vRzG3hUYQ88kWFYuowUu5wJZ8KXXGNazNlZEJoRxYgR7ALiMCXsZieiFRSP6A2LGb6CFHVdsxb6ADkuKDGR7gWd1JMek6NSSq/2lHtT+m23LvbtCGAJYyi/oI/W5t1r4HamQ3SXGgHL34HmAKaFWyGHa/PyEZDs2XY5HB7rfQl434MHKWgAQKBgQDd01XD5FQ0hLgmQ0XJH9KVfy6hQEdgWrv2xWSJj8DHmV2ypxdbq6suzu4cpT789Jgd4UMc8w1NzT1XlRBoi6emtIUpcUx3NrgNsj/akQm81rHPnFLy+U+u5fo/ZKnFUCSE9gFmkNMfqVGGJ8SSAN5DqNLwFkemRTWqKEgv9srmIQKBgQCc0gTavbghzTGLXfIZiSvZ4hAtM8ATQfeyb/az6zrniEi4OG6SqBDfNCnATKVemWNppf7kEejsHY/ipcdBu0YQtbW/LfmAGsAXSCK1PXtMWAB/xy+haKO0HNVJQHi/pqJRYosiNZjDTO35gaadZQ46tC4E/uekcvdPT/zu0NxKwQKBgQCM/cFahCr9QoolT8bwYfigKrlBprB3TtR/sdEIGkWm2BUU811GV+OzGbWAoYtajkCNZVsZ8GY5WEUwAL/wIyvJKp4kzC2U7EOp+OzbCCrPSwqzcaHLa6k4+lXHqzy4/ApqNE6JmW2Hh0AY6/fl8QVUrd582TxrMzw7zeSsD8nA4QKBgDsTIqEENwkEs1U83qaf9dTuRAnDJOgcQaMGanj8dAQkYsCDAaRdi32JuPCn7uPkBH8X+R0RYh0QRdOrf5RTZ+GDkiOivgp0CUi789cygfAQdp+r+VVkhcaj1fTyRIpty1e9N4x7hECOClejb5B7MREMLwnSvJBGfsNx7mZIZ7QBAoGBAIaZz3dHRbZa7qjBo3L2EdieRgiF0l8CI/eDh4w5DNZzHSkfXjisMKYvMAIRcabUP2l40HWgXx711t2pT7wjfERbxVjPiq09bwtCiiNWSQvPwrKh8FVkD6cVr7VYSGlzi0AyyegxW6uii3gBG8ubhbcZczKHTpYXlj8gTadLGnDb";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://"+URL+"/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	//public static String return_url = "http://"+URL+"/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA+Q+hrjJrbcYjrO5pe0/x7K1nf8T7rGbhonW4ErkT0NzXPm8ztKbp11M2ZELwJFGdJwctiOE5d6i0l/G+tqqPWFSAygvtZKSJMp44zEl0kvwW3opHKC0eSIrir2Fst5Khw24V+1x2RTxUzbbxtQTxqqGQaVP0W5BeVVN9OUUh6hCxAUnRmjxoAEaCYs27zV25BigOGxT96j796G1wy04XmL2AigCbCtboIUKB/pFnWSj0hTC9dHRJAaOtZCclMgEM53JIl+VAom8u0JL8sWrQ+uLbPEL2izPOkPuaMK0creJhWbRBZnBd75XR2ImGwpZxzxZu127Yx4UteDsu6dVdwQIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
