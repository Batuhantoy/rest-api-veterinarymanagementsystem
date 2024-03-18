package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.IAppointmentService;
import dev.patika.spring.business.abstracts.IReportService;
import dev.patika.spring.core.mapper.IAppointmentMapper;
import dev.patika.spring.core.mapper.IReportMapper;
import dev.patika.spring.dal.abstracts.IReportRepository;
import dev.patika.spring.model.dto.requests.ReportRequest;
import dev.patika.spring.model.dto.responses.ReportResponse;
import dev.patika.spring.model.entity.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportService implements IReportService {

    private final IReportRepository reportRepository;
    private final IReportMapper reportMapper;
    private final IAppointmentMapper appointmentMapper;
    private final IAppointmentService appointmentService;

    public List<ReportResponse> findAll() {
        return reportMapper.asOutput(reportRepository.findAll());
    }

    public ReportResponse getById(Long id) {
        return reportMapper.asOutput(reportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Report with ID " + id + " not found in the system!")));
    }

    public ReportResponse add (ReportRequest reportRequest) {
        Optional<Report> isReportExist = reportRepository.findByAppointmentId(reportRequest.getAppointment().getId());
        if (isReportExist.isEmpty()) {
            reportRequest.setAppointment(appointmentService.findById(reportRequest.getAppointment().getId())); // id altinda null gorunen field ler null olmayacak/
            Report reportSaved = reportRepository.save(reportMapper.asEntity(reportRequest));
            return reportMapper.asOutput(reportSaved);
        }
        throw new RuntimeException("This report with this appointment has already been registered in the system!");
    }

    public ReportResponse update(Long id, ReportRequest reportRequest) {
        Optional<Report> reportFromDb = reportRepository.findById(id);
        Optional<Report> isReportExist = reportRepository.findByAppointmentId(reportRequest.getAppointment().getId());

        if (reportFromDb.isEmpty()) {
            throw new RuntimeException("The report with the ID " + id + " that you are trying to update could not be found in the system!");
        }
        if (isReportExist.isPresent()) {
            throw new RuntimeException("This report has already been registered in the system.");
        }
        reportRequest.setAppointment(appointmentService.findById(reportRequest.getAppointment().getId()));
        Report report = reportFromDb.get();
        reportMapper.update(report, reportRequest);
        return reportMapper.asOutput((reportRepository.save(report)));
    }


    public void delete(Long id) {
        Optional<Report> reportFromDb =reportRepository.findById(id);
        if (reportFromDb.isPresent()) {
            reportRepository.delete(reportFromDb.get());
        } else {
            throw new RuntimeException("Report with ID " + id + " could not be found in the system!");
        }
    }
}
