package springmvcdemo01.jt.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HandlerMapping
 *
 * @author Administrator
 */
@Controller
public class AnnnotationHelloController {
    @RequestMapping("/doHelloUI.do")//url,定义处理器url的映射
    public ModelAndView doHelloUI() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "hello spring mvc");
        return mv;
    }

    @RequestMapping("/doSayHello.do")
    public ModelAndView doSayHello(ModelAndView mv) {
        mv.setViewName("hello");
        mv.addObject("msg", "do say Hello");
        return mv;
    }

    @RequestMapping("/doSayWelcome.do")
    public String doSayWelcome(Model m) {
        m.addAttribute("msg", "do say welcome");
        return "hello";//view
    }


}
