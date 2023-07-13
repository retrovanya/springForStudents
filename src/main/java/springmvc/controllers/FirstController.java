package springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname );
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "action") String action,
                                 Model model) {
        if (actionComparing(action)==1) model.addAttribute("resultMessage",
                "result of multiplication : " + multiplication(a,b));
        if (actionComparing(action)==2) model.addAttribute("resultMessage",
                "result of addition : " + addition(a,b));
        if (actionComparing(action)==3) model.addAttribute("resultMessage",
                "result of subtraction : " + subtraction(a,b));
        if (actionComparing(action)==4) model.addAttribute("resultMessage",
                "result of division : " + division(a,b));
        return "first/calculator";
    }

    public int addition(int a, int b) {
        return a+b;
    }

    public int multiplication(int a, int b) {
        return a*b;
    }

    public int subtraction(int a, int b) {
        return a-b;
    }

    public double division(int a, int b) {
        if (b==0) throw new ArithmeticException("you can't divide by zero");
        return (double) a/b;
    }

    public int actionComparing(String action) {
        if (action.equals("multiplication")) return 1;
        if (action.equals("addition")) return 2;
        if (action.equals("subtraction")) return 3;
        if (action.equals("division")) return 4;
        return 0;
    }


}
