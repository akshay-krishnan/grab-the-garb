from flask import Flask
import MySQLdb
import sys
import datetime

app = Flask(__name__)




@app.route('/')
def home():
	connection = MySQLdb.connect (host = "10.24.32.31", user = "root", passwd = "", db = "tricon")
	cursor = connection.cursor ()
	cursor.execute ("select * from govt")
	data = cursor.fetchall()

	dict_today = {}
	dict_week = {}
	#print datetime.date.today()
	#print data
	for row in data:
		if row[4] == 1:
			if row[3] == datetime.date.today():
				dict_today[row[0]] = (row[1], row[2], row[3])
			else:
				dict_week[row[0]] = (row[1], row[2], row[3])
	print dict_week
	print dict_today
	cursor.close ()
	connection.close ()
	str1 = "<b>Garbage collection monitoring system for Mysore</b></br></br>"
	str1 = str1 + "Number of complaints today: "+str(len(dict_today))
	if len(dict_today) >0:
		str1 = str1 + '</br><table style="width:100%" border="1">\
		<tr>\
		<th>Phone</th>\
		<th>Address</th> \
		<th>date</th>\
			</tr>'
		for i in dict_today:
			str1 = str1+"<tr>\
			<td>"+str(dict_today[i][0])+"</td>\
			<td>"+str(dict_today[i][1])+"</td>\
			<td>"+str(dict_today[i][2])+"</td>\
		 	</tr>"
		str1=str1+"</table>"

	str1 = str1 + "</br></br>Number of older complaints: "+str(len(dict_week))
	if len(dict_week) >0:
		str1 = str1 + '</br><table style="width:100%" border="1">\
		<tr>\
		<th>Phone</th>\
		<th>Address</th> \
		<th>date</th>\
		</tr>'
		for i in dict_week:
			str1 = str1+"<tr>\
			<td>"+str(dict_week[i][0])+"</td>\
			<td>"+str(dict_week[i][1])+"</td>\
			<td>"+str(dict_week[i][2])+"</td>\
		 	</tr>"
		str1=str1+"</table>"
	

	return str1


if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0')



