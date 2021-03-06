package com.niit.vhrend.controller.per;

import com.niit.vhrend.model.RespBean;
import com.niit.vhrend.model.RespPageBean;
import com.niit.vhrend.model.Sector;
import com.niit.vhrend.model.Train;
import com.niit.vhrend.service.per.SectorService;
import com.niit.vhrend.service.per.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnel/train")
public class TrainController {
    @Autowired
    TrainService trainService;
    @Autowired
    SectorService sectorService;
    @GetMapping("/")
    public RespPageBean getTrainByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Train train) {
        return trainService.getTrainByPage(page, size, train);
    }
    @GetMapping("/train")
    public List<Train> getAllTrain() {
        return trainService.getAllTrain();
    }

    @GetMapping("/sector")
    public List<Sector> getAllSector() {
        return sectorService.getAllSector();
    }
    @PostMapping("/")
    public RespBean addTrain(@RequestBody Train train) {
        if (trainService.addTrain(train) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteEcById(@PathVariable Integer id) {
        if (trainService.deleteTrainById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
    @PutMapping("/")
    public RespBean updateTrain(@RequestBody Train train) {
        if (trainService.updateTrain(train) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
