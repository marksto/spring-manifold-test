package name.marksto.manifoldtest.controller;

import manifold.api.templ.DisableStringLiteralTemplates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@DisableStringLiteralTemplates // TODO: Must work without it since 'strings' plugin argument is off!
public class GreetingController {

    @Value("${app.default.name}")
    private String defaultName;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false) String name, Model model) {
        model.addAttribute("name", name == null ? defaultName : name);
        return "greeting";
    }

}