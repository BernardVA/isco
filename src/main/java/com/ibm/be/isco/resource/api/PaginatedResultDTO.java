package com.ibm.be.isco.resource.api;

import java.util.List;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PaginatedResultDTO<T> {

  private long totalSize;
  private int pageSize;
  private int pageCount;
  private int pageNumber;
  private int firstPageNumber;
  private int lastPageNumber;
  private Integer previousPageNumber;
  private Integer nextPageNumber;
  private String sortBy;
  private List<T> content;

  public static <T> PaginatedResultDTO<T> from(Page<T> page) {
    PaginatedResultDTO<T> apiPage = new PaginatedResultDTO<>();
    apiPage.totalSize = page.getTotalElements();
    apiPage.pageSize = page.getSize();
    apiPage.pageCount = page.getTotalPages();
    apiPage.pageNumber = page.getNumber();
    apiPage.firstPageNumber = 0;
    apiPage.lastPageNumber = Math.max(0, page.getTotalPages() - 1);
    apiPage.previousPageNumber = page.hasPrevious() ? page.getNumber() - 1 : null;
    apiPage.nextPageNumber = page.hasNext() ? page.getNumber() + 1 : null;
    apiPage.sortBy = page.getSort().toString();
    apiPage.content = page.getContent();
    return apiPage;
  }
}
