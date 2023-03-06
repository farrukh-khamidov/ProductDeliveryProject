package uz.farrukh.library.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DatatableOutput<T> {
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data;
}
