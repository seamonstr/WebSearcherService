package org.redcabbage.WebSearcher;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.redcabbage.WebSearcher.model.Searcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.redcabbage.WebSearcher.model.SearchResult;

import java.util.List;

@RestController
@RequestMapping("/search")
public class WebSearcherService {

  @Getter
  @Setter(onMethod=@__({@Autowired(), @Qualifier("hardcodedSearcher")}))
  private Searcher searcher;


  @GetMapping
  List<SearchResult> search(String search) {
    if (StringUtils.isNotEmpty(search))
      return searcher.search(search);
    return null;
  }
}
