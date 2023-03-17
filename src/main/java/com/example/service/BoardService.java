package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Attach;
import com.example.model.Board;
import com.example.model.Reply;
import com.example.repository.AttachRepository;
import com.example.repository.BoardRepository;
import com.example.repository.ReplyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	private final ReplyRepository replyRepository;
	private final AttachRepository attachRepository;

	//////////////////////////////////////////////////
	// create
	@Transactional
	public Board createBoard(Board board) {
		return boardRepository.save(board);
	}
	@Transactional	
	public Reply createReply(Reply reply) {
		return replyRepository.save(reply);
	}
	@Transactional
	public Attach createAttach(Attach attach) {
		return attachRepository.save(attach);
	}
	//////////////////////////////////////////////////
	// read
	public List<Board> readAll() {
		return boardRepository.findAll();
	}
	
	public List<Reply> getReply(Integer bno) {
		return replyRepository.findAllByBno(bno);
	}
	
	public List<Attach> getAttach(Integer bno) {
		return attachRepository.findAllByBno(bno);
	}
	//////////////////////////////////////////////////
	// update
	@Transactional
	public Board update(Board board) {
		Board updatedBoard = boardRepository.findById(board.getBno()).get();
		updatedBoard.update(board.getTitle(),board.getContent());
		
		Board updateSuccess = boardRepository.findById(board.getBno()).get();
		return updateSuccess;
	}
	@Transactional
	public Reply update(Reply reply) {
		Reply updatedReply = replyRepository.findById(reply.getRno()).get();
//		updatedReply.setReplytext(reply.getReplytext());
		updatedReply.update(reply.getReplytext(), reply.getReplyer());
		Reply updatedSuccess = replyRepository.findById(reply.getRno()).get();
		return updatedSuccess;
//		return replyRepository.save(updatedReply);
	}
	@Transactional
	public Attach update(Attach attach) {
		Attach updatedAttach = attachRepository.findByFullnameAndBno(attach.getFullname(), attach.getBno().getBno());
		updatedAttach.setFullname(attach.getFullname());
		return attachRepository.save(updatedAttach);
	}
	//////////////////////////////////////////////////
	// delete
	@Transactional
	public Board delete(Integer bno) {
		Board deleteBoard = boardRepository.findById(bno).get();
		boardRepository.deleteById(bno);
		return deleteBoard;
	}
	@Transactional
	public Reply delete(Integer rno, String key) {
		Reply deleteReply = replyRepository.findById(rno).get();
		replyRepository.deleteById(rno);
		return deleteReply;
	}
	@Transactional
	public Attach delete(String fullname, Integer bno) {
		Attach deleteAttach = attachRepository.findByFullnameAndBno(fullname, bno);
		attachRepository.deleteByFullnameAndBno(fullname,bno);
		return deleteAttach;
	}
}
