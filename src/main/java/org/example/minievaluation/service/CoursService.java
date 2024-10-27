package org.example.minievaluation.service;

import org.example.minievaluation.dao.CoursDao;
import org.example.minievaluation.dao.ICoursDao;
import org.example.minievaluation.dto.CoursDto;
import org.example.minievaluation.entities.CoursEntity;
import org.example.minievaluation.mapper.CoursMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService implements ICoursService {
    private ICoursDao coursDao = new CoursDao();

    @Override
    public Optional<List<CoursDto>> findAll() {
        List<CoursEntity> accountUserEntityList = coursDao.list(new CoursEntity());

        return Optional.of(CoursMapper.toListCoursDto(accountUserEntityList));
    }

    @Override
    public boolean save(CoursDto coursDto) {
        return coursDao.save(CoursMapper.toCoursEntity(coursDto));
    }
}
