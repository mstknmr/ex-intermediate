package com.example.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.baseball.service.BaseballService;

/**
 * Baseballのコントローラークラス
 * 
 * @author knmrmst
 */
@Controller
@RequestMapping("/baseball")
public class BaseballController {
	@Autowired
	BaseballService baseballService;
	
	/**
	 * チームリスト画面への遷移.
	 * <p>
	 * 全チームの情報のリストをサービスクラスから受け取ってモデルに格納する。
	 * その後、チームリスト画面に遷移する。
	 * </p>
	 * @param model モデル
	 * @return チームリスト表示画面
	 * 
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		model.addAttribute("teamList", baseballService.showTeamList());
		return "baseball/team-list";
		
	}
	
	/**　
	 * チーム詳細画面への遷移.
	 * <p>
	 * チームIDを受け取って、チーム情報を主キー検索したのちに、チーム詳細ページに遷移する。
	 * </p>
	 * @param id　チーム
	 * @param model　モデル
	 * @return　チーム詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id , Model model) {
		if(id>baseballService.showTeamList().size()) {
			return "redirect:/baseball/showList";
		}
		model.addAttribute("team",baseballService.showDetail(id));
		return "baseball/team-detail";
	}
	
	/**
	 * チームリスト画面へのリダイレクト
	 * <p>
	 * チーム画面リストをリダイレクトで表示させる。
	 * </p>
	 * 
	 * @return チームリスト画面
	 */
	@RequestMapping("/back")
	public String back() {
		return "redirect:/baseball/showList";
	}

}
