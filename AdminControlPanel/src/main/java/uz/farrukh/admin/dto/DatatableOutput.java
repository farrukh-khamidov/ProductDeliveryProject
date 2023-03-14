package uz.farrukh.admin.dto;

import lombok.Data;

import java.util.List;

@Data
public class DatatableOutput {
    private long recordsTotal;
    private long recordsFiltered;
    private List<Object[]> data;
}
