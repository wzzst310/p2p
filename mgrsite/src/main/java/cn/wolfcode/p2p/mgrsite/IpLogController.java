package cn.wolfcode.p2p.mgrsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import cn.wolfcode.p2p.base.domain.IpLog;
import cn.wolfcode.p2p.base.query.IpLogQueryObject;
import cn.wolfcode.p2p.base.service.IIpLogService;


/**
 * 后台登陆控制器
 * 
 * Created by WangZhe on 2018/7/23.
 */
@Controller
public class IpLogController {
    @Autowired
    private IIpLogService ipLogService;
    
    /**
     * 查看登陆信息
     * @param qo 
     * @param model
     * @return
     */
    @RequestMapping("ipLog")
    public String ipLogPage(@ModelAttribute("qo") IpLogQueryObject qo, Model model) {
        PageInfo<IpLog> pageResult = ipLogService.queryPage(qo);
        model.addAttribute("pageResult", pageResult);
        return "/iplog/list";
    }
}
