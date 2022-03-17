package com.binar.grab.repository;

import com.binar.grab.model.Barang;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BarangRepository extends
        PagingAndSortingRepository<Barang, Long> {
    @Query("select c from Barang c")// nama class
    Page<Barang> getAllData(Pageable pageable);

    @Query("select c from Barang c WHERE c.id=:id")// nama class
    public   Barang getByID(@Param("id") Long id);

    @Query("select c from Barang c where c.nama =:nama ")// nama class
    public Page <Barang> findByNama(String nama , Pageable pageable);

    public Page <Barang> findByNamaLike(String nama , Pageable pageable);

    @Query("select c from Barang c where  c.harga BETWEEN :priceMin and :priceMax")// nama class
    Page<Barang> getDataByPrice( Double priceMin, Double priceMax, Pageable pageable);

    @Query("select c from Barang c where  c.harga BETWEEN :priceMin and :priceMax and c.nama like :nama")// nama class
    Page<Barang> getDataByPriceAndNama( Double priceMin, Double priceMax,String nama, Pageable pageable);


    @Query("select c from Barang c where lower(c.nama) like :nama ")// nama class
    public Page <Barang> findByNamaLower(String nama , Pageable pageable);
}

