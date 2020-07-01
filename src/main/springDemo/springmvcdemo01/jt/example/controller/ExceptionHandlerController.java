package springmvcdemo01.jt.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/arg/")
public class ExceptionHandlerController {
    @RequestMapping(value = "/dodiv", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String doDiv(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("参数null");

        }
        return "result=" + a / b;

    }

    /**
     * 此方法捕获上面的异常类型，返回页面正常的字符串
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String doHandleException(Exception e) {
        return e.getMessage();
    }
}
