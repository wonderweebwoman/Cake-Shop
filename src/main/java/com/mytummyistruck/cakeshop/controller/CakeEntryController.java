// package com.mytummyistruck.cakeshop.controller;

// import java.util.*;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.mytummyistruck.cakeshop.entity.CakeEntry;

// @RestController
// @RequestMapping("/cakes")
// public class CakeEntryController {

//     private Map<Long, CakeEntry> cakes = new HashMap<>();

//     @GetMapping
//     public List<CakeEntry> getCakeEntry(){
//         return new ArrayList<>(cakes.values());
//     }

//     @GetMapping("/id/{myId}")
//     public CakeEntry getCakeEntryById(@PathVariable Long myId){
//         return cakes.get(myId);
//     }

//     @PostMapping
//     public String createCakeEntry(@RequestBody CakeEntry newEntry){
//         cakes.put(newEntry.getId(), newEntry);
//         return "Accepted!";
//     }

//     @PutMapping("/id/{myId}")
//     public String updateCakeEntry(@PathVariable Long myId, @RequestBody CakeEntry newEntry){
//         cakes.put(myId, newEntry);
//         return "Accepted!";
//     }

//     @DeleteMapping("/id/{myId}")
//     public String deleteCakeEntry(@PathVariable Long myId){
//         cakes.remove(myId);
//         return "Entry Deleted";
//     }

// }
