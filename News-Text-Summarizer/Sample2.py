from __future__ import absolute_import
from __future__ import division, print_function, unicode_literals
from sumy.parsers.html import HtmlParser
from sumy.parsers.plaintext import PlaintextParser
from sumy.nlp.tokenizers import Tokenizer
from sumy.summarizers.lsa import LsaSummarizer as Summarizer
from sumy.nlp.stemmers import Stemmer
from sumy.utils import get_stop_words
import urllib.request
from bs4 import BeautifulSoup
import codecs
import re

open("Urls2.txt", 'w').close()
open("Content2.txt", 'w').close()

def swrite(dat):
	file=open("Content2.txt","w")
	file.write(dat)
	file.close()

def twrite(dat):
	file=open("Urls2.txt","a")
	file.write(dat)
	file.close()	
	
news="https://timesofindia.indiatimes.com"
conn=urllib.request.urlopen(news).read()
LANGUAGE = "czech"
SENTENCES_COUNT = 7

if(conn):
	print ('URL Opened\n')
	var1=BeautifulSoup(conn.decode('utf-8'),'html.parser')
	data=var1.find_all("div",{"class":"top-story"})
	data[0]=str(data[0])
	swrite(data[0])
	with open ('Content2.txt', 'rt') as in_file:
		lines = [] #Declare an empty list named "lines"
		for line in in_file: #For each line of text store in a string variable named "line", and
			match = re.search(r'href=[\'"]?([^\'" >]+)', line)
			if match:
				twrite(match.group(0)+"\n")
	with open ('Urls2.txt', 'rt') as in_file:
		urls = [] #Declare an empty list named "urls"
		for url in in_file: #For each line of text store in a string variable named "url", and
			urls.append(url)  #add that url to our list of urls.
				
	for i in range (len(urls)):
		if "href=\"" in urls[i]:
			urls[i]=urls[i].replace("href=\"","https://timesofindia.indiatimes.com")
for i in range(0,4):
	url=urls[i][:-1]
	t1=urllib.request.urlopen(url).read()
	var2=BeautifulSoup(t1.decode('utf-8'),'html.parser')
	parser = HtmlParser.from_url(url, Tokenizer(LANGUAGE))
	stemmer = Stemmer(LANGUAGE)
	summarizer = Summarizer(stemmer)
	summarizer.stop_words = get_stop_words(LANGUAGE)
	for sentence in summarizer(parser.document, SENTENCES_COUNT):
		print(sentence)
	print("===================================")





