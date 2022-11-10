package com.api.blog.post.model.post;

import com.api.blog.post.db.entity.TbComment;
import com.api.blog.post.db.entity.TbEntry;
import com.api.blog.post.model.RequestModel;

public class PostEntryCommentRequestModel extends RequestModel {
	private TbEntry tbEntry;
	
	private TbComment tbComment;

	public TbEntry getTbEntry() {
		return tbEntry;
	}

	public void setTbEntry(TbEntry tbEntry) {
		this.tbEntry = tbEntry;
	}

	public TbComment getTbComment() {
		return tbComment;
	}

	public void setTbComment(TbComment tbComment) {
		this.tbComment = tbComment;
	}
}
