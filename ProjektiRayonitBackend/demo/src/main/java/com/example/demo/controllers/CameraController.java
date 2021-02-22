package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Camera;
import com.example.demo.repository.CameraRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class CameraController {

	@Autowired
	private CameraRepository repository;
	private List<String> res = new ArrayList<>(6);

	@PostMapping(value = "/create")
	public Camera createCamera(@RequestBody Camera camera) {
		return repository.save(camera);
	}

	@GetMapping("/camerasAll")
	public List<Camera> getCameras() {
		return repository.findAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteCamera(@PathVariable int id) {
		repository.deleteById(id);
	}

	@GetMapping(value="/chart", produces= {"application/json"})
	public List<String> getResolutions(){
		List<Camera> camera = repository.findAll(); // ruan gjithe camerat e db
		Iterator<Camera> it = camera.iterator(); // iterator mbi listen e camerave
			while (it.hasNext()) {
				String r = it.next().getResolution();  //rezolucioni i cdo camere
				res.add(r);			
		}
		return res;
	}

}
	






//public List<String> getResolutions() {
//List<Camera> camera = repository.findAll(); // ruan gjithe camerat e db
//Iterator<Camera> it = camera.iterator(); // iterator mbi listen e camerave
//while (it.hasNext()) {
//	String r = it.next().getResolution();  //rezolucioni i cdo camere
//	//String r = ((Camera) it).getResolution(); // merr arg ne poz 3 (indexet 0-4)
//	res.add(r);
//}
//	return res; // lista me rezolucionet e cdo camere
//}
//}
//


//	public ResponseEntity<List<String>> getResolutions(){
//	try {
//	List<Camera> cameras = repository.findAll(); 
//	List<String> resolution = repository.findByResolution(cameras); // ruan gjithe rez
//	if (resolution.isEmpty()) {
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
//	return new ResponseEntity<>(resolution, HttpStatus.OK);
//	}catch (Exception e) {
//	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
//	
//}
	

	
	
// ....

//	@PostMapping("/create")
//	public ResponseEntity<Camera> createCamera(@RequestBody Camera camera) {
//		  try {
//		    Camera c = repository.save(new Camera(camera.getId(), camera.getName(), camera.getModel(), camera.getResolution(), camera.getIp()));
//		    return new ResponseEntity<>(c, HttpStatus.CREATED);
//		  } catch (Exception e) {
//		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		  }
//		}

//	@GetMapping("/camerasAll")
//	public ResponseEntity<List<Camera>> getCameras(@RequestParam String name) {
//		  try {
//		    List<Camera> cameras = new ArrayList<Camera>();
//
//		    if (name == null)
//		      repository.findAll().forEach(cameras::add);
//		    else
//		      repository.findByNameContaining(name).forEach(cameras::add);
//
//		    if (cameras.isEmpty()) {
//		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		    }
//
//		    return new ResponseEntity<>(cameras, HttpStatus.OK);
//		  } catch (Exception e) {
//		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		  }
//		}
//
//	@GetMapping("/cameras/{id}")
//	public ResponseEntity<Camera> getCameraById(@PathVariable("id") int id) {
//	  Optional<Camera> camera = repository.findById(id);
//
//	  if (camera.isPresent()) {
//	    return new ResponseEntity<>(camera.get(), HttpStatus.OK);
//	  } else {
//	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	  }
//	}
//	
//	@GetMapping("/chart")
//	public ResponseEntity<List<Camera>> findByResolution() {
//	  try {
//	    List<Camera> cameras = repository.findByResolution();
//
//	    if (cameras.isEmpty()) {
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    }
//	    return new ResponseEntity<>(cameras, HttpStatus.OK);
//	  } catch (Exception e) {
//	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	  }
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<HttpStatus> deleteCamera(@PathVariable("id") int id){
//		try {
//			repository.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch(Exception e){
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

