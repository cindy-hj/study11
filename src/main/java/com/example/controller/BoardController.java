package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Attach;
import com.example.model.Board;
import com.example.model.Reply;
import com.example.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {
	private BoardService boardService;

	// read
	@GetMapping("/boards")
	public ResponseEntity<List<Board>> getBoardAll() {
		log.info("get board all list");
		List<Board> boards = boardService.readAll();
		return new ResponseEntity<List<Board>>(boards, HttpStatus.OK);
	}
	@GetMapping("/replys/{bno}")
	public ResponseEntity<List<Reply>> getReplyAll(@PathVariable Integer bno) {
		log.info("get reply all list");
		List<Reply> replys = boardService.getReply(bno);
		return new ResponseEntity<List<Reply>>(replys,HttpStatus.OK);
	}
	@GetMapping("/attach/{bno}")
	public ResponseEntity<List<Attach>> getAttachAll(@PathVariable Integer bno) {
		log.info("get attach all list");
		List<Attach> attachs = boardService.getAttach(bno);
		return new ResponseEntity<List<Attach>>(attachs, HttpStatus.OK);
	}

	// create
	@PostMapping("/boards")
	public ResponseEntity<Board> createBoard(@RequestBody Board board) {
		log.info("create board");
		Board postBoard = boardService.createBoard(board);
		return new ResponseEntity<Board>(postBoard,HttpStatus.CREATED);
	}
	
	@PostMapping("/replys") 
	public ResponseEntity<Reply> createReply(@RequestBody Reply reply) {
		log.info("create reply");
		Reply postReply = boardService.createReply(reply);
		return new ResponseEntity<Reply>(postReply, HttpStatus.CREATED);
	}
	
	@PostMapping("/attachs")
	public ResponseEntity<Attach> createAttach(@RequestBody Attach attach) {
		log.info("create attach");
		Attach postAttach = boardService.createAttach(attach);
		return new ResponseEntity<Attach>(postAttach,HttpStatus.CREATED);
	}
	
	// update
	@PutMapping("/boards")
	public ResponseEntity<Board> updateBoard(@RequestBody Board board) {
		log.info("update board");
		Board updateBoard = boardService.update(board);
		return new ResponseEntity<Board>(updateBoard, HttpStatus.ACCEPTED);
	}
	@PutMapping("/replys")
	public ResponseEntity<Reply> updateReply(@RequestBody Reply reply) {
		log.info("update reply");
		Reply updateReply = boardService.update(reply);
		return new ResponseEntity<Reply>(updateReply, HttpStatus.ACCEPTED);
	}
	@PutMapping("/attachs")
	public ResponseEntity<Attach> updateAttach(@RequestBody Attach attach) {
		Attach updateAttach = boardService.update(attach);
		return new ResponseEntity<Attach>(updateAttach, HttpStatus.ACCEPTED);
	}
	
	// delete
	@DeleteMapping("/boards/{bno}")
	public ResponseEntity<Board> deleteBoard(@PathVariable Integer bno) {
		log.info("delete board");
		Board deleteBoard = boardService.delete(bno);
		return new ResponseEntity<Board>(deleteBoard, HttpStatus.OK);
	}
	@DeleteMapping("/reply/{bno}")
	public ResponseEntity<Reply> deleteReply(@PathVariable Integer bno) {
		log.info("delete reply");
		Reply deleteReply = boardService.delete(bno, null);
		return new ResponseEntity<Reply>(deleteReply, HttpStatus.OK);
	}
	@DeleteMapping("/attach")
	public ResponseEntity<Attach> deleteAttach(@RequestParam("fullname")String fullname, @RequestParam("bno")Integer bno) {
		log.info("delete attach");
		Attach deleteAttach = boardService.delete(fullname, bno);
		return new ResponseEntity<Attach>(deleteAttach, HttpStatus.OK);
	}
}
