package org.example.minievaluation.mapper;


import org.example.minievaluation.dto.CoursDto;
import org.example.minievaluation.entities.CoursEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CoursMapper {
    public static CoursEntity toCoursEntity(CoursDto coursDto) {
        CoursEntity coursEntity = new CoursEntity();
        coursEntity.setId(coursDto.getId());
        coursEntity.setMatiere(coursDto.getMatiere());
        coursEntity.setProfesseur(coursDto.getProfesseur());
        coursEntity.setClasse(coursDto.getClasse());

        return coursEntity;
    }

    public static CoursDto toCoursDto(CoursEntity coursEntity) {
        CoursDto coursDto = new CoursDto();
        coursDto.setId(coursEntity.getId());
        coursDto.setMatiere(coursEntity.getMatiere());
        coursDto.setProfesseur(coursEntity.getProfesseur());
        coursDto.setClasse(coursEntity.getClasse());

        return coursDto;
    }

    public static List<CoursDto> toListCoursDto(List<CoursEntity> coursEntities) {
        return coursEntities.stream()
                .map(CoursMapper::toCoursDto)
                .collect(Collectors.toList());
    }
}
