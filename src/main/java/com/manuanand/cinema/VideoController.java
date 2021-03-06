package com.manuanand.cinema;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/video") // This means URL's start with /video (after Application path)
public class VideoController {
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<Video> getAllVideos() {
		
		// This returns a JSON or XML with the users
		return videoRepository.findAll();
	}

	@GetMapping(path="/{id}")
	public @ResponseBody Video getSpecificVideo(@PathVariable String id) {
		
		Integer videoId = null;
		try {
			videoId = Integer.parseInt(id);
		} catch (NumberFormatException ex) {
			return null;
		}

		Optional<Video> video = videoRepository.findById(videoId);
		if (!video.isEmpty()) {
			return video.get();
		} 

		return null;
	}
}