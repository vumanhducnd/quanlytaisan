package com.website.qlts.controller;

import com.website.qlts.entity.GroupAssets;
import com.website.qlts.service.GroupAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/group-assets")
public class GroupAssetsController {
    @Autowired
    GroupAssetsService groupAssetsService;

    @RequestMapping("")
    public String indexPage(Model model, String keyWord) {
        List<GroupAssets> listAssets;
        if (keyWord != null) {
            listAssets = groupAssetsService.getByName(keyWord);
        } else {
            listAssets = groupAssetsService.getAll();
        }

        model.addAttribute("cate", listAssets);
        return "pages/group-assets/index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("cate", new GroupAssets());
        return "pages/group-assets/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(@ModelAttribute GroupAssets groupAssets, Model model) {
        model.addAttribute("cate", groupAssets);
        groupAssetsService.create(groupAssets.getGroupName());
        return "redirect:/group-assets/";
    }

    @RequestMapping("/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) {
        GroupAssets assets = groupAssetsService.getById(id).get();
        model.addAttribute("cate", assets);
        return "pages/group-assets/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String editPage(@RequestParam String groupName, @PathVariable("id") long id, Model model, @ModelAttribute GroupAssets groupAssets) {
        model.addAttribute("cate", groupAssets);
        groupAssetsService.update(id, groupName);
        return "redirect:/group-assets/";
    }

    @RequestMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) {
        groupAssetsService.delete(id);
        return "redirect:/group-assets/";
    }
}
