package ch.quickline.business.dao;

import org.openrdf.model.Model;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.LinkedHashModel;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.Update;
import org.openrdf.query.UpdateExecutionException;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.model.Statement;

public class SesameStudentDao implements StudentDao {
	
	public SesameStudentDao(){
		
	}
	
	public void insertStudent(String staffID, String first_name, String last_name) {
		try {
			RepositoryConnection con = SesameDaoFactory.createConnection();
		
		
<<<<<<< HEAD
		String updateString = "PREFIX ab: <http://people.brunel.ac.uk/~csstnns/university.owl#> PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> INSERT DATA { ab:Student7 rdf:type owl:NamedIndividual }";
		Update update = con.prepareUpdate(QueryLanguage.SPARQL, updateString);
=======
		String updateString =   "PREFIX ab: <http://people.brunel.ac.uk/~csstnns/university.owl#>" +
							   "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
							   "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
							   "INSERT DATA { ab:Lectuter10 rdf:type owl:NamedIndividual ." +
							   "ab:Lecturer10 rdf:type ab:Lecturer ." +
							   "ab:Lecturer10 ab:staffID ? ." +
							   "ab:Lecturer10 ab:first_name ? ." +
							   "ab:Lecturer10 ab:last_name ? }";
>>>>>>> refs/remotes/origin/oguz
		
		
		Update update = con.prepareUpdate(QueryLanguage.SPARQL, updateString);

		update.execute();
		
		System.out.println("Succesfully added a new Student");
		
		} 
		
		
		catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (UpdateExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
	}
	
	public void deleteStudent(){
		
	
	}
	
	public void findStudent(){
		
	}

}
