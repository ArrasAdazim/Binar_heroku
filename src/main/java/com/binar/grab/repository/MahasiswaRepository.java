package com.binar.grab.repository;

import com.binar.grab.model.Mahasiswa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MahasiswaRepository  extends
        PagingAndSortingRepository<Mahasiswa,Long> {

    @Query("select c from Mahasiswa c WHERE c.id = :id")
    public Mahasiswa getByID(@Param("id") Long id);
}
