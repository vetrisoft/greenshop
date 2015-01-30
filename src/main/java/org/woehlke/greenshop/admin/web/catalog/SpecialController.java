package org.woehlke.greenshop.admin.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.admin.AdminService;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.model.*;
import org.woehlke.greenshop.catalog.service.LanguageService;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
@Controller
public class SpecialController {

    @Inject
    private AdminService adminService;

    @Inject
    private CatalogService catalogService;

    @Inject
    private LanguageService languageService;

    @RequestMapping(value = "/admin/specials", method = RequestMethod.GET)
    public String specials(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        List<SpecialProduct> specials = catalogService.getSpecialProducts(language);
        model.addAttribute("specials",specials);
        SpecialProduct thisSpecial = null;
        if(specials.size()>0){
            thisSpecial = specials.iterator().next();
        }
        model.addAttribute("thisSpecial",thisSpecial);
        return "admin/specials";
    }

    @RequestMapping(value = "/admin/specials/{productId}", method = RequestMethod.GET)
    public String specialsId(@PathVariable long productId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        List<SpecialProduct> specials = catalogService.getSpecialProducts(language);
        model.addAttribute("specials",specials);
        SpecialProduct thisSpecial = null;
        if(specials.size()>0){
            thisSpecial = catalogService.findSpecialProductById(productId, language);
        }
        model.addAttribute("thisSpecial",thisSpecial);
        return "admin/specials";
    }

    @RequestMapping(value = "/admin/specials/setInactive/{productId}", method = RequestMethod.GET)
    public String specialSetInactive(@PathVariable long productId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        SpecialProduct thisSpecial = catalogService.findSpecialProductById(productId, language);
        Special special=thisSpecial.getSpecial();
        special.setStatus(false);
        special.setStatusChanged(new Date());
        adminService.updateSpecial(special);
        thisSpecial = catalogService.findSpecialProductById(productId,language);
        model.addAttribute("thisSpecial",thisSpecial);
        List<SpecialProduct> specials = catalogService.getSpecialProducts(language);
        model.addAttribute("specials",specials);
        return "admin/specials";
    }

    @RequestMapping(value = "/admin/specials/setActive/{productId}", method = RequestMethod.GET)
    public String specialSetActive(@PathVariable long productId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        SpecialProduct thisSpecial = catalogService.findSpecialProductById(productId,language);
        Special special=thisSpecial.getSpecial();
        special.setStatus(true);
        special.setStatusChanged(new Date());
        adminService.updateSpecial(special);
        thisSpecial = catalogService.findSpecialProductById(productId,language);
        model.addAttribute("thisSpecial",thisSpecial);
        List<SpecialProduct> specials = catalogService.getSpecialProducts(language);
        model.addAttribute("specials",specials);
        return "admin/specials";
    }
}
