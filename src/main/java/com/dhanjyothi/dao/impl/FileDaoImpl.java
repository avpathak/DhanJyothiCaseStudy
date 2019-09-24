package com.dhanjyothi.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.dhanjyothi.dao.FileDao;
import com.dhanjyothi.model.FileEntity;

@Repository
public class FileDaoImpl implements FileDao {

	public void saveFileUpload(FileEntity fileEntity) {

	}

	public List<FileEntity> viewAllFiles() {
		return null;
	}

	public List<FileEntity> findByName(String fileName) {

		return null;
	}

}
