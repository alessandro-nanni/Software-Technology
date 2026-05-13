import PyPDF2

def chapters(input_pdf, page_ranges, output_prefix):
    # Apri il file PDF in modalità lettura binaria
    with open(input_pdf, 'rb') as pdf_file:
        # Crea un lettore PDF
        reader = PyPDF2.PdfReader(pdf_file)
        
        for i, (start_page, end_page) in enumerate(page_ranges):
            writer = PyPDF2.PdfWriter()

            for page_num in range(start_page - 1, end_page):
                writer.add_page(reader.pages[page_num])

            output_pdf = f"{output_prefix}_{i +1}.pdf"
            
            with open(output_pdf, 'wb') as output_file:
                writer.write(output_file)

            print(f"Sezione {i + 1}: Pagine {start_page} a {end_page} salvata in '{output_pdf}'.")

input_pdf = "sm/book pressman.pdf" 
page_ranges = [(31,44),(47,75),(83,105),(107,138),(141,170),(173,189),(193,219),(221,247),(253,268),(273,297),(299,325),(327,361),(363,390),(393,427),(429,448),(451,463),(465,503),(505,533),(535,565),(569,596),(599,629),(631,657),(659,678),(681,697),(701,725),(727,747),(749,773),(775,794),(797,825),(827,851),(853,871),(873,881)]  
output_prefix = "sm/chapters/chapter"

chapters(input_pdf, page_ranges, output_prefix)