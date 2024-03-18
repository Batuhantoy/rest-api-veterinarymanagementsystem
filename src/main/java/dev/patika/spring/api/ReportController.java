package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.IReportService;
import dev.patika.spring.model.dto.requests.ReportRequest;
import dev.patika.spring.model.dto.responses.ReportResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/reports")
@AllArgsConstructor
public class ReportController {

    private final IReportService reportService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ReportResponse> findAll() {
        return reportService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportResponse getById(@PathVariable("id")Long id) {
        return reportService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ReportResponse add(@RequestBody ReportRequest report) {
        return reportService.add(report);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportResponse update(@PathVariable Long id, @RequestBody ReportRequest reportRequest) {
        return reportService.update(id, reportRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        reportService.delete(id);
    }

}
