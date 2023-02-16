package com.pz.phrase.cntrl;

import com.pz.phrase.model.dto.AccountInfo;
import com.pz.phrase.model.entity.AccountConfig;
import com.pz.phrase.model.map.AccountConfigMapper;
import com.pz.phrase.srvc.AccountConfigService;
import com.pz.phrase.srvc.ProjectsService;
import com.pz.phrase.srvc.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class WebController {

    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private AccountConfigService accountConfigService;
    @Autowired
    private ProjectsService projectsService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

    @GetMapping("/config")
    public String viewConfigPage(Model model, HttpServletRequest request) {
        AccountInfo dto = AccountConfigMapper.toDTO(accountConfigService.getMainRow());
        model.addAttribute("config", dto);

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            model.addAttribute("message", inputFlashMap.get("message"));
        }

        return "config";
    }

    @PostMapping("/config")
    public String saveConfig(@Valid @ModelAttribute("config") AccountInfo dto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            AccountConfig entity = accountConfigService.getMainRow();
            AccountConfigMapper.toEntity(dto, entity);
            accountConfigService.save(entity);
            tokenProvider.invalidateToken();
        }
        redirectAttributes.addFlashAttribute("message", bindingResult.hasErrors() ? "Save error - there were validation errors" : "Saved OK");

        return "redirect:/config";
    }

    @GetMapping("/projects")
    public String viewProjectsPage(Model model) {
        //model.addAttribute("projects", projectsService.getProjects());
        return "projects";
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Model model, Exception ex) {
        model.addAttribute("error", String.format("Application ran into an error: %s, %s", ex.getMessage(), ex.getCause()));
        return "error";
    }
}
