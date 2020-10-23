#!/user/bin/python
from pymongo import MongoClient
from pymongo import errors
import sys
import json
from bson import json_util

connection = MongoClient('localhost',27017)
db = connection['market']
collection = db['stocks']
def insert_document(document):
  try:
    collection.insertOne(document)
    flag = True
  except ValidationError as ve:
    print("Duplicate key")
    flag = False
  except error.WriteError as we:
    print(str(we))
    flag = False
  except errors.OperationFailure as of:
    print(str(of))
    flag = False
  return flag

def main():
  myDocument = {"Ticker" : "A", "Sector" : "Healthcare", "Country" : "USA"}
  print insert_document(myDocument)
  main()

def search_document(document):
  try:
    result = collection.findOne(document)
    if(result == None):
      result = "Error not found"
    except errors.OperationFailure as of:
      result = str(of)
    return result
  
def update_document(my query.newvalues):
  try:
    collection.updateOne(my query.newvalues)
    result = search_document(newvalues["$set"])
  except errors.DuplicateKeyError as dke:
    result = str(dke)
  except errors.OperationFailure as of:
    resilt = str(of)
  return result

def deleteOne(string)
  try:
    collection.deleteOne(string)
    string = {"Ticker"}
  except NameError:
    abort(404, "Not Found")
  if not string:
    abort(404, "Not Found")
  return delete_document(string)

def search_document(query):
  try:
    collection.findOne(query)
    query = {"50-Day Simple Moving Average" : {"$gt":high,"$lt":low}}
    result = collection.find(query).count()
    if(result == None):
      result = "Error not found"
    except errors.OperationFailure as of:
      result = str(of)
    return result
  
def search_document(string):
  try:
    collection.find(string)
    string = {"Industry":industryName}
    result = collection.find(string)
    if(result == None):
      result = "Error not found"
    except errors.OperationFailure as of:
      result = str(of)
    return result
  
def aggregation(query):
  try:
    collection.aggregation(query)
    query = {'$match':{"Sector":sectorName}}
            {'$group':{'_id':"$Industry", 'Total Outstanding Shares:':{'$sum':"$Shares Outstanding"}}}
    result = collection.aggregation(query)
    if(result == None):
      result = "Error not found"
    except errors.OperationFailure as of:
      result = str(of)
    return result
  
  