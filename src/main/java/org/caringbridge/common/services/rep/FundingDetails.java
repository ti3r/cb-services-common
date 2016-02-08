package org.caringbridge.common.services.rep;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object that will carry the information about the current status
 * of a founding campaign in the external founding provider systems.
 * 
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
public class FundingDetails {

    /**
     * Default constructor with no values for the fields.
     */
    public FundingDetails() {
        super();
    }

    /**
     * Constructor with values for all the fields.
     * 
     * @param goal
     *            The Double goal of the campaign
     * @param contributionsTotal
     *            The Double current total of the contributions
     * @param contributionsCount
     *            The Double current number of contributions
     */
    public FundingDetails(final Double goal, final Double contributionsTotal, final Double contributionsCount) {
        this.goal = goal;
        this.contributionsTotal = contributionsTotal;
        this.contributionsCount = contributionsCount;
    }

    /**
     * The targeted amount for the campaign. This amount could be less than the
     * total contributions if the goal was exceeded.
     */
    private Double goal;

    /**
     * The total amount of contributions.
     */
    private Double contributionsTotal;

    /**
     * The total number of contributions, likely represents the number of
     * contributors.
     */
    private Double contributionsCount;

    /**
     * @return the goal
     */
    @JsonProperty("goal")
    public Double getGoal() {
        return goal;
    }

    /**
     * @param goal
     *            the goal to set
     */
    public void setGoal(final Double goal) {
        this.goal = goal;
    }

    /**
     * @return the contributionsTotal
     */
    @JsonProperty("contributions_total")
    public Double getContributionsTotal() {
        return contributionsTotal;
    }

    /**
     * @param contributionsTotal
     *            the contributionsTotal to set
     */
    public void setContributionsTotal(final Double contributionsTotal) {
        this.contributionsTotal = contributionsTotal;
    }

    /**
     * @return the contributionsCount
     */
    @JsonProperty("contributions_count")
    public Double getContributionsCount() {
        return contributionsCount;
    }

    /**
     * @param contributionsCount
     *            the contributionsCount to set
     */
    public void setContributionsCount(final Double contributionsCount) {
        this.contributionsCount = contributionsCount;
    }
    
    /**
	 * The url used to retrieve the fundingdetail.
	 */
	
	private String url;

	/**
	 * @return the url
	 */
	@JsonProperty(value = "url", required = true)
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

}
