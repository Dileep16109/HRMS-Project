package com.hrms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrms.entities.Employee;
import com.hrms.entities.Titles;
import com.hrms.entities.TitlesId;

@Repository
public interface TitlesRepository extends JpaRepository<Titles, TitlesId> {

    @Query("SELECT t FROM Titles t WHERE t.employee.empNo = :empNo AND t.fromDate = :fromDate AND t.title = :title")
    List<Titles> findByTypeId(@Param("empNo") int empNo, @Param("fromDate") LocalDate fromDate,
            @Param("title") String title);

    List<Titles> findByEmployee(Employee employee);


    @Query("SELECT t FROM Titles t WHERE t.title = :title")
    List<Titles> findByTitles(@Param("title") String title);

 

    @Query("SELECT t FROM Titles t WHERE t.fromDate = :fromDate")
    List<Titles> findByFromDate(@Param("fromDate") LocalDate fromDate);

 

    @Query("SELECT t FROM Titles t WHERE t.fromDate = :fromDate AND t.title = :title")
    List<Titles> findByFromDateAndTitle(@Param("fromDate") LocalDate fromDate, @Param("title") String title);

 

    @Query("SELECT t FROM Titles t WHERE t.employee.empNo = :empNo AND t.title = :title")
    List<Titles> findByEmpnoAndTitle(@Param("empNo") int empNo, @Param("title") String title);

 

    @Query("SELECT t FROM Titles t WHERE t.employee.empNo = :empNo AND t.fromDate = :fromDate")
    List<Titles> findByFromDateAnDempNo(@Param("empNo") int empNo, @Param("fromDate") LocalDate fromDate);    

    Titles findByEmployee_EmpNoAndFromDateAndTitle(int empNo, LocalDate fromDate, String title);
    
    Titles findByEmployee_EmpNo(int empNo);
    
    @Query("SELECT t FROM Titles t WHERE t.fromDate = :fromDate")
    Titles findByFromDate1(LocalDate fromDate);
    

      Titles findByTitle(String title);


	@Modifying
	@Query("DELETE FROM Titles t WHERE t.employee.empNo = :empNo AND t.fromDate = :fromDate AND t.title = :title")
	void deleteByEmployee_EmpNoAndFromDateAndTitle(
			@Param("empNo") int empNo, 
			@Param("fromDate") LocalDate fromDate,
			@Param("title") String title);

	@Modifying
	@Query("DELETE FROM Titles t WHERE t.employee.empNo = :empNo")
	void deleteByEmployee_EmpNo(@Param("empNo") int empNo);

	@Modifying
	@Query("DELETE FROM Titles t WHERE t.fromDate = :fromDate")
	void deleteByFromDate(@Param("fromDate") LocalDate fromDate);

	@Modifying
	@Query("DELETE FROM Titles t WHERE t.title = :title")
	void deletebyTitle(@Param("title") String title);

    @Query("SELECT t FROM Titles t WHERE t.employee.empNo = :empNo")
	List<Titles> findByempNo(int empNo);

    




}
