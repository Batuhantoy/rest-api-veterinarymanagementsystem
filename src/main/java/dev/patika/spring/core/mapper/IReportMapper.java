package dev.patika.spring.core.mapper;

import dev.patika.spring.model.dto.requests.ReportRequest;
import dev.patika.spring.model.dto.responses.ReportResponse;
import dev.patika.spring.model.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IReportMapper {

    Report asEntity(ReportRequest reportRequest);
    @Mappings({
            @Mapping(source = "appointment.doctor.name",target = "doctorName") ,
            @Mapping(source = "appointment.animal.customer.name",target = "customerName"),
            @Mapping(source = "appointment.animal.name",target = "animalName"),

    })
    ReportResponse asOutput(Report report);


    @Mappings({
            @Mapping(source = "appointment.doctor.name",target = "doctorName") ,
            @Mapping(source = "appointment.animal.customer.name",target = "customerName"),
            @Mapping(source = "appointment.animal.name",target = "animalName"),
            //   @Mapping(source = "appointment.animal.vaccine.name", target = "vaccineName")
    })
    List<ReportResponse> asOutput(List<Report> reportList);

    //    @Mappings({
//            @Mapping(source = "appointment.doctor.name",target = "doctorName") ,
//            @Mapping(source = "appointment.animal.customer.name",target = "customerName"),
//            @Mapping(source = "appointment.animal.name",target = "animalName")
//    })
    void update(@MappingTarget Report entity, ReportRequest request);

}
