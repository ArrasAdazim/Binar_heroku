package com.binar.grab.repository;

import com.binar.grab.model.Karyawan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends PagingAndSortingRepository<Karyawan, Long> {
    @Query("select c from Karyawan c where c.id = :id")
    public Karyawan getById(@Param("id") Long id);
}
