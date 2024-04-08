package com.hrms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.hrms.entities.DepartmentManager;
import com.hrms.entities.DepartmentManagerId;


@Repository
public interface DepartmentManagerRepository extends JpaRepository<DepartmentManager, DepartmentManagerId> {


	DepartmentManager findByEmployee_EmpNoAndDepartment_DeptNoAndFromDate(int empNo, String deptNo, LocalDate fromDate);

	DepartmentManager findByDepartment_DeptNoAndFromDate(String deptNo, LocalDate fromDate);

	DepartmentManager findByEmployee_EmpNoAndFromDate(int empNo, LocalDate fromDate);

	DepartmentManager findByEmployee_EmpNoAndDepartment_DeptNo(int empNo, String deptNo);
	
	List<DepartmentManager> findByDepartmentDeptNo(String deptNo);
	
	List<DepartmentManager> findByEmployee_EmpNo(int empNo);

	List<DepartmentManager> findByDepartmentDeptNoAndFromDate(String deptNo, LocalDate fromDate);
	
	
	  @Query("SELECT dm.employee.empNo, dm.employee.firstName, dm.employee.hireDate  FROM DepartmentManager dm WHERE dm.fromDate >= :fromDate")
	  List<Object[]> findEmployeesFromDate(@Param("fromDate") LocalDate fromDate);
	

	@Modifying
	@Query("DELETE FROM DepartmentManager dm WHERE dm.employee.empNo = :empNo AND dm.department.deptNo = :deptNo AND dm.fromDate = :fromDate")
	void deleteByEmpNoAndDeptNoAndFromDate(@Param("empNo") int empNo, @Param("deptNo") String deptNo,
			@Param("fromDate") LocalDate fromDate);

	@Modifying
	@Query("DELETE FROM DepartmentManager dm WHERE dm.employee.empNo = :empNo AND dm.department.deptNo = :deptNo")
	void deleteByEmpNoAndDeptNo(@Param("empNo") int empNo, @Param("deptNo") String deptNo);

	@Modifying
	@Query("DELETE FROM DepartmentManager dm WHERE dm.employee.empNo = :empNo AND dm.fromDate = :fromDate")
	void deleteByEmpNoAndFromDate(@Param("empNo") int empNo, @Param("fromDate") LocalDate fromDate);

	@Modifying
	@Query("DELETE FROM DepartmentManager dm WHERE dm.department.deptNo = :deptNo AND dm.fromDate = :fromDate")
	void deleteByDeptNoAndFromDate(@Param("deptNo") String deptNo, @Param("fromDate") LocalDate fromDate);
	
	@Modifying
	@Query("DELETE FROM DepartmentManager dm WHERE dm.department.deptNo = :deptNo")
	void deleteByDeptNo(@Param("deptNo") String deptNo);
	
	@Modifying
	@Query("DELETE FROM DepartmentManager dm WHERE dm.employee.empNo = :empNo")
	void deleteByEmpNo(@Param("empNo") int empNo);



}
