package com.example.miniPj;

import com.example.miniPj.dto.InfoDto;
import com.example.miniPj.dto.MainDto;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@org.springframework.stereotype.Controller
public class Controller {

    public static Map<String, InfoDto> mainMap=new HashMap<>();

    //리스트 불러오기
    @GetMapping("/parcel/list")
    public String list(Model model){
        System.out.println("list : mainMap = "+mainMap);

        model.addAttribute("mainMap" , mainMap.entrySet());
        

        return "list";
    }//m end

    @GetMapping("/parcel/input")
    public String input(){

        return "input";
    }//m end

    @PostMapping("/parcel/insert")
    public String insert(InfoDto infoDto, MainDto mainDto){
        Random random=new Random();
        String invoice="";
        int a;

        for(int i=0; i<11; i++){
            a=random.nextInt(9);
            invoice+=Integer.toString(a);
        }
        System.out.println("invoice = " + invoice);

        System.out.println("Controller.insert");
        System.out.println("infoDto = " + infoDto);
        System.out.println("mainDto = "+ mainDto);

        mainMap.put(invoice,infoDto);
        System.out.println("mainMap = " + mainMap);

        return "redirect:/parcel/list";
    }//m end

    @GetMapping("/parcel/{invoice}/delete")
    public String delete(@PathVariable String invoice){
        System.out.println("Controller.delete");
        mainMap.remove(invoice);

        return "redirect:/parcel/list";
    }//m end

}//c end
