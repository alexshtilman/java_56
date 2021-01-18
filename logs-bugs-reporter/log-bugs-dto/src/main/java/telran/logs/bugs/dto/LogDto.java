package telran.logs.bugs.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LogDto {
    @NotNull
    public Date dateTime;
    @NotNull
    public LogType logType;
    @NotEmpty

    public String artefact;

    public int responseTime;
    public String result;

    public LogDto(@NotNull Date dateTime, @NotNull LogType logType, @NotEmpty String artefact, int responseTime,
	    String result) {
	super();
	this.dateTime = dateTime;
	this.logType = logType;
	this.artefact = artefact;
	this.responseTime = responseTime;
	this.result = result;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((artefact == null) ? 0 : artefact.hashCode());

	result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
	result = prime * result + ((logType == null) ? 0 : logType.hashCode());
	result = prime * result + responseTime;
	result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
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
	LogDto other = (LogDto) obj;
	if (artefact == null) {
	    if (other.artefact != null)
		return false;
	} else if (!artefact.equals(other.artefact))
	    return false;
	if (dateTime == null) {
	    if (other.dateTime != null)
		return false;
	} else if (!dateTime.equals(other.dateTime))
	    return false;
	if (logType != other.logType)
	    return false;
	if (responseTime != other.responseTime)
	    return false;
	if (result == null) {
	    if (other.result != null)
		return false;
	} else if (!result.equals(other.result))
	    return false;
	return true;
    }

}
