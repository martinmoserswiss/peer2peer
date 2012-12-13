package ch.bfh.advancedweb.peer2peer.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.Loan;
import ch.bfh.advancedweb.peer2peer.model.LoanStatus;

public class LoanTest {
	
	@Test
	public void crud(){
		
		/* ------ Create -------*/
		
		Loan loan = new Loan();
		loan.setStatus(LoanStatus.pending);
		loan.setInterest_rate(10.0);
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
		
		/* ------ Created -------*/
		
		/* ------ Udpate -------*/
		
		Query q = em.createQuery("select a from Loan a where a.interest_rate=:rate");
		q.setParameter("rate", 10.0);
		
		@SuppressWarnings("unchecked")
		List<Loan> foundLoans = q.getResultList();
		Loan firstLoan = foundLoans.get(0);

		em.getTransaction().begin();
		firstLoan.setInterest_rate(11.0);
		em.getTransaction().commit();
		
		/* ------ Udpated -------*/
		
		/* ------ Delete -------*/
		
		Query deleteQuery = em.createQuery("select a from Loan a where a.interest_rate=:rate");
		deleteQuery.setParameter("rate", 11.0);
		@SuppressWarnings("unchecked")
		List<Loan> foundLoansToDelete = deleteQuery.getResultList();
		Loan firstLoanToDelte = foundLoansToDelete.get(0);
		
		if(firstLoanToDelte != null){
			
			// Write access needs a transaction
			em.getTransaction().begin();
			em.remove(firstLoanToDelte);
			em.getTransaction().commit();
			
		}
		
		/* ------ Deleted -------*/
	}
}
