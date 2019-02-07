package com.revature.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="ERS_REIMBURSEMENT")
@DynamicUpdate
public class Reimbursement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="REIMBURSEMENT_ID")
	@GeneratedValue
	private int id;
	
	@Column(name="REIMBURSEMENT_AMOUNT", nullable=false)
	private double amount;
	
	@Column(name="REIMBURSEMENT_SUBMITTED_DATE", nullable=false) 
	private Timestamp submittedDate;
	
	@Column(name="REIMBURSEMENT_DESCRIPTION", nullable=false)
	private String description;
	
	@Column(name="REIMBURSEMENT_AUTHOR_ID", nullable=false)
	private int authorId;
	
	@Column(name="REIMBURSEMENT_RESOLVER_ID")
	private int resolverId;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="REIMBURSEMENT_STATUS")
	private Status status;
	
	@NotNull
	@Column(name="REIMBURSEMENT_TYPE_ID")
	private int typeId;

	public Reimbursement() {
		this.submittedDate = new Timestamp(System.currentTimeMillis());
	}

	public Reimbursement(int id, double amount, String description, int authorId, int resolverId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submittedDate = new Timestamp(System.currentTimeMillis());
		this.description = description;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.status = Status.Pending;
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmittedDate() {
		return submittedDate.toString();
	}

	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + authorId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + resolverId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submittedDate == null) ? 0 : submittedDate.hashCode());
		result = prime * result + typeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (authorId != other.authorId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (resolverId != other.resolverId)
			return false;
		if (status != other.status)
			return false;
		if (submittedDate == null) {
			if (other.submittedDate != null)
				return false;
		} else if (!submittedDate.equals(other.submittedDate))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submittedDate=" + submittedDate + ", description="
				+ description + ", authorId=" + authorId + ", resolverId=" + resolverId + ", status=" + status
				+ ", typeId=" + typeId + "]";
	}

	

}
