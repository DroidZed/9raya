'use strict';

export default function RespObj({ message = '', status = 0, object }) {
	this.message = message;
	this.object = object;
	this.status = status;
}
