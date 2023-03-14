package uz.farrukh.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatatableOutput<T> {
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data;
}
