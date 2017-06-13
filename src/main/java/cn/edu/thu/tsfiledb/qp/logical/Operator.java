package cn.edu.thu.tsfiledb.qp.logical;

import cn.edu.thu.tsfiledb.qp.constant.SQLConstant;

/**
 * This class is a superclass of all operator.
 *
 * @author kangrong
 * @author qiaojialin
 *
 */
public abstract class Operator {
	protected int tokenIntType;
	protected String tokenName;

	protected OperatorType operatorType = OperatorType.NULL;

	public Operator(int tokenIntType) {
		this.tokenIntType = tokenIntType;
		this.tokenName = SQLConstant.tokenNames.get(tokenIntType);
	}

	public OperatorType getType() {
		return operatorType;
	}

	public boolean isQuery() {
		return operatorType == OperatorType.QUERY;
	}

	public int getTokenIntType() {
		return tokenIntType;
	}

	public String getTokenName() {
		return tokenName;
	}

	@Override
	public String toString() {
		return tokenName;
	}

	public enum OperatorType {
		SFW, JOIN, UNION, FILTER, GROUPBY, ORDERBY, LIMIT, SELECT, SEQTABLESCAN, HASHTABLESCAN, MERGEJOIN, FILEREAD, NULL, TABLESCAN,
		UPDATE, MULTIINSERT, DELETE, BASIC_FUNC, QUERY, AUTHOR, FROM, FUNC, LOADDATA, METADATA, PROPERTY, FlUSH, MERGE
		,
		OVERFLOWFLUSHSTART, // 25 // ordinal()
		OVERFLOWFLUSHEND, // 26
		BUFFERFLUSHSTART, // 27
		BUFFERFLUSHEND; // 28
	}
}
