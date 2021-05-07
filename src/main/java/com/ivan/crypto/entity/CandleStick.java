package com.ivan.crypto.entity;

import java.math.BigDecimal;

public class CandleStick implements Comparable<CandleStick> {

	private long startTime;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	private BigDecimal volume;
	
	public CandleStick() {
		this.startTime = 0;
		this.open = BigDecimal.ZERO;
		this.high = BigDecimal.ZERO;
		this.low = BigDecimal.ZERO;
		this.close = BigDecimal.ZERO;
		this.volume = BigDecimal.ZERO;
	}
	
	public CandleStick(long startTime, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
		this.startTime = startTime;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}
	
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getClose() {
		return close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public void addVolume(BigDecimal volume) {
		this.volume = this.volume.add(volume);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CandleStick [startTime=");
		builder.append(startTime);
		builder.append(", open=");
		builder.append(open);
		builder.append(", high=");
		builder.append(high);
		builder.append(", low=");
		builder.append(low);
		builder.append(", close=");
		builder.append(close);
		builder.append(", volume=");
		builder.append(volume);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(CandleStick o) {	// to sort in ascending order
		return Long.compare(startTime, o.getStartTime());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((close == null) ? 0 : close.hashCode());
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + ((low == null) ? 0 : low.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result + (int) (startTime ^ (startTime >>> 32));
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		return result;
	}

	/*	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof CandleStick)) {
			return false;
		}
		if (this.getStartTime() == ((CandleStick)obj).getStartTime() 
				&& (this.getOpen().compareTo(((CandleStick)obj).getOpen()) == 0) 
				&& (this.getClose().compareTo(((CandleStick)obj).getClose()) == 0) 
				&& (this.getHigh().compareTo(((CandleStick)obj).getHigh()) == 0) 
				&& (this.getLow().compareTo(((CandleStick)obj).getLow()) == 0)
				&& (this.getVolume().compareTo(((CandleStick)obj).getVolume()) == 0)
				) {
			return true;
		}
		return false;
	}
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CandleStick other = (CandleStick) obj;
		if (close == null) {
			if (other.close != null) {
				return false;
			}
		} else if (close.compareTo(other.close) != 0) {
			System.out.println("close not equal");
			return false;
		}
		if (high == null) {
			if (other.high != null) {
				return false;
			}
		} else if (high.compareTo(other.high) != 0) {
			System.out.println("high not equal");
			return false;
		}
		if (low == null) {
			if (other.low != null) {
				return false;
			}
		} else if (low.compareTo(other.low) != 0) {
			System.out.println("low not equal");
			return false;
		}
		if (open == null) {
			if (other.open != null) {
				return false;
			}
		} else if (open.compareTo(other.open) != 0) {
			System.out.println("open not equal");
			return false;
		}
		if (startTime != other.startTime) {
			System.out.println("start time not equal");
			return false;
		}
		if (volume == null) {
			if (other.volume != null) {
				return false;
			}
		} else if (volume.compareTo(other.volume) != 0) {
			System.out.println("volume not equal");
			return false;
		}
		return true;
	}
	
}
