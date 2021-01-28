package com.example.databox.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EcharsAction {
    @GetMapping("/mychart")
    public  String chartPage(Model model) {
        List<Integer> lists = new ArrayList<>();
        lists.add(12);
        lists.add(32);
        lists.add(62);
        lists.add(62);
        lists.add(72);
        lists.add(52);
        model.addAttribute("mydata", lists);
        return "mychart";
    }

}
