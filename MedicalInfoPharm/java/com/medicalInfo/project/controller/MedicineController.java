package com.medicalInfo.project.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medicalInfo.project.model.MedicineResponse;
import com.medicalInfo.project.model.QaDTO;
import com.medicalInfo.project.service.MedicineService;
import com.medicalInfo.project.service.QaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@Log4j
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	@RequestMapping(value = "/medisearch", method = RequestMethod.GET)
	public String wholelist(Model model) {
		System.out.println("컨트롤러 체크");
		// Model : 뷰에 데이터를 전달하여 사용자에게 표시하는데 사용 set attribute 랑 비슷(하지만 단타성)
		//model.addAttribute("testData","이거 전달됨?");
		// HttpServletResponse : HTTP 응답을 설정하는데 사용, 상태코드, 헤더, 리다이렉트 등을 설정
		List<MedicineResponse> r= medicineService.medicineSearch();
		model.addAttribute("testapi",r);
			
		return "medisearch"; //test.jsp 로 이동
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testlist(Model model) {
		System.out.println("컨트롤러 체크");
		// Model : 뷰에 데이터를 전달하여 사용자에게 표시하는데 사용 set attribute 랑 비슷(하지만 단타성)
		//model.addAttribute("testData","이거 전달됨?");
		// HttpServletResponse : HTTP 응답을 설정하는데 사용, 상태코드, 헤더, 리다이렉트 등을 설정
		MedicineResponse r= MedicineService.apiTest();
		model.addAttribute("testapi",r);		
		return "test"; //test.jsp 로 이동
	}
	
	@ResponseBody
	@RequestMapping(value="/medsearch", method = RequestMethod.GET)
	public void medicineSearch(Model model) throws UnsupportedEncodingException {		
		System.out.println("컨트롤러 리퀘스트 체크:");
		
	}
	

	
	@ResponseBody // ajax로 호출되는 url 과 매핑된 경우 필수로 작성
	@RequestMapping(value="/ajaxTest", method = RequestMethod.GET)
	public MedicineResponse ajaxTest() {
		System.out.println("ajax 버튼 클릭시 컨트롤러 이동");
		return medicineService.apiTest();
	}
	
	
	@GetMapping("/addmedi")
    public void addmedi( @RequestParam String entpName,
            @RequestParam String itemName,
            @RequestParam String itemSeq,
            @RequestParam String efcyQesitm,
            @RequestParam String useMethodQesitm,
            @RequestParam String intrcQesitm,
            @RequestParam String seQesitm,
            @RequestParam String depositMethodQesitm,
            @RequestParam String itemImage,
            @RequestParam String bizrno,Model model) {

        model.addAttribute("entpName", entpName)
        .addAttribute("itemName", itemName)
        .addAttribute("itemSeq", itemSeq)
        .addAttribute("efcyQesitm", efcyQesitm)
        .addAttribute("useMethodQesitm", useMethodQesitm)
        .addAttribute("intrcQesitm", intrcQesitm)
        .addAttribute("seQesitm", seQesitm)
        .addAttribute("depositMethodQesitm", depositMethodQesitm)
        .addAttribute("itemImage", itemImage)
        .addAttribute("bizrno", bizrno);
    
    }
	
	
	
}
	
	
