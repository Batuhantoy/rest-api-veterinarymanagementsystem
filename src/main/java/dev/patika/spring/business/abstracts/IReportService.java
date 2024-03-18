package dev.patika.spring.business.abstracts;

import dev.patika.spring.model.dto.requests.ReportRequest;
import dev.patika.spring.model.dto.responses.ReportResponse;

import java.util.List;

public interface IReportService {

    public List<ReportResponse> findAll();
    public ReportResponse getById(Long id);
    public ReportResponse add (ReportRequest reportRequest);
    public ReportResponse update(Long id, ReportRequest reportRequest);
    public void delete(Long id);


}
