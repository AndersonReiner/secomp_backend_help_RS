package com.anderson.secomp_backend_help_RS.service;

import com.anderson.secomp_backend_help_RS.dto.CollectPointDto;
import com.anderson.secomp_backend_help_RS.model.CollectPoint;
import com.anderson.secomp_backend_help_RS.model.User;
import com.anderson.secomp_backend_help_RS.repository.CollectPointRepository;
import com.anderson.secomp_backend_help_RS.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CollectPointService {


    private final CollectPointRepository pointRepository;
    private final UserRepository userRepository;

    public CollectPointService(CollectPointRepository pointRepository, UserRepository userRepository) {
        this.pointRepository = pointRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveCollectPoint(CollectPointDto dto){
        CollectPoint collectPoint = new CollectPoint();
        collectPoint.setName(dto.name());
        collectPoint.setStartTime(dto.startTime());
        collectPoint.setFinishTime(dto.finishTime());
        collectPoint.setOpenDonation(dto.openDonation());
        collectPoint.setUser(userRepository.findById(dto.user_id()).get());
        pointRepository.save(collectPoint);
    }


    public void deleteCollectPoint(Integer id){
        pointRepository.deleteById(id);
    }

    public List<CollectPoint> getAllCollectPoint(){
        return pointRepository.findAll();
    }

    @Transactional
    public CollectPointDto getById(Integer id){
        Optional<CollectPoint> point =   pointRepository.findById(id);
        Optional<User> user = userRepository.findById(point.get().getId());
        CollectPointDto dto = new CollectPointDto(point.get().getName(), point.get().getStartTime(), point.get().getFinishTime(), point.get().isOpenDonation(), user.get().getId());
        return  dto;
    }

    public void updateNamePoint(CollectPoint point){

    }


}
