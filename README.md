# Catalog Task-01
JD2 IT-Academy Task Application
**(console version)**

This application allows you to store news about the released movies, disks, books.

The original data is stored in the file "catalog.xml"  XML-file structure:
`<CATALOG>

     <CATEGORY>
         <CATEGORY_NAME>Films(exmpl)</CATEGORY_NAME>
         <SUBCATEGORY>
             <SUBCATEGORY_NAME> Some name </SUBCATEGORY_NAME>
             <NEWS_NAME> First News </NEWS_NAME>
             <PROVIDER_AUTHOR_AUTHORS> ... </PROVIDER_AUTHOR_AUTHORS>
             <DATE_OF_ISSUE> .... </DATE_OF_ISSUE>
             <NEWS_BODY>....... </NEWS_BODY>
         </SUBCATEGORY>
         <SUBCATEGORY>
             <SUBCATEGORY_NAME> .... </SUBCATEGORY_NAME>
             <NEWS_NAME> Second News </NEWS_NAME>
             <PROVIDER_AUTHOR_AUTHORS>  ... </PROVIDER_AUTHOR_AUTHORS>
             <DATE_OF_ISSUE> ... </DATE_OF_ISSUE>
             <NEWS_BODY> ... </NEWS_BODY>
         </SUBCATEGORY>
         </CATEGORY>
     <CATEGORY>
         <CATEGORY_NAME>Books(exmpl)</CATEGORY_NAME>
         <SUBCATEGORY>
             <SUBCATEGORY_NAME> .... </SUBCATEGORY_NAME>
         ................
             <NEWS_BODY> ... </NEWS_BODY>
         </SUBCATEGORY>
     </CATEGORY>
 </CATALOG>`
Implemented the functionality of adding news and searching news in the catalog
 
 # Example
 ![srshcatalog](https://user-images.githubusercontent.com/42671888/44870429-eca45800-ac98-11e8-81ab-bb304579f26f.JPG)
 
 # Usage
 
 You must save the file **catalog.xm**l from directory _catalog/src/main/resources/_

to any folder **and copy the path to this folder** 

Edit file **JAXB.properties** from directory _catalog/src/main/resources/_

->>> **paste path** to file **catalog.xml** 

Example :

url=D:/Somefolder/catalog.xml
 
 

 
