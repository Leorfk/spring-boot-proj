package com.leorfk.workshopmongo.resource;

import com.leorfk.workshopmongo.domain.Post;
import com.leorfk.workshopmongo.resource.util.URL;
import com.leorfk.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService postServ;

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = postServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){

		text = URL.decodeParam(text);
		List<Post> list = postServ.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value="titlesearch/query", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitleQuery(@RequestParam(value = "text", defaultValue = "") String text){

		text = URL.decodeParam(text);
		List<Post> list = postServ.findByTitleQuery(text);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue="") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = postServ.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
